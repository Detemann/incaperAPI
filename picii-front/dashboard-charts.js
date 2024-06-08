const serverIp = "http://168.138.248.181" //"http://localhost"

document.addEventListener('DOMContentLoaded', function () {
    fetchChartData();

    function fetchChartData(days = 7) {
        fetch(serverIp+':8080/soil')
            .then(response => response.json())
            .then(data => {
                data = data.slice(-days);
                updateCharts(data);
            })
            .catch(error => console.error('Erro ao buscar dados:', error));
    }

    function updateCharts(data) {
        const lastSample = data[data.length - 1];

        // NPK data for Pie Chart
        const pieData = [0, 0, 0];
        data.forEach(sample => {
            pieData[0] += sample.n_perc;
            pieData[1] += sample.p_perc;
            pieData[2] += sample.k_perc;
        });
        let total = pieData.reduce((a, b) => a + b, 0);
        pieData.forEach((val, index) => {
            pieData[index] = ((val / total) * 100).toFixed(2);
        });

        const pieChartConfig = {
            type: 'doughnut',
            data: {
                labels: ['N%', 'P%', 'K%'],
                datasets: [{
                    data: pieData,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top'
                    }
                }
            }
        };

         // Arrays para guardar os dados de N, P e K para cada uma das últimas 7 leituras
            const nData = [];
            const pData = [];
            const kData = [];
            const labels = [];

            // Pegando os últimos 7 registros (ou menos, se não houver 7)
            const recentData = data.slice(-7);
            recentData.forEach(sample => {
                nData.push(sample.n_perc.toFixed(2));
                pData.push(sample.p_perc.toFixed(2));
                kData.push(sample.k_perc.toFixed(2));
                // Formatando a data/hora para ser usada como rótulo
                labels.push(`${sample.dataHora.substring(0, 10)} ${sample.dataHora.substring(11, 19)}`);
            });

            // Configuração do gráfico de barras N-P-K
            const barChartConfig = {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [
                        {
                            label: 'N%',
                            data: nData,
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'P%',
                            data: pData,
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'K%',
                            data: kData,
                            backgroundColor: 'rgba(255, 206, 86, 0.2)',
                            borderColor: 'rgba(255, 206, 86, 1)',
                            borderWidth: 1
                        }
                    ]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top'
                        }
                    }
                }
            };
        // Humidity Line Chart
        const humidityData = data.map(sample => sample.umidade_perc.toFixed(2));
        const humidityLabels = data.map(sample => `${sample.dataHora.substring(0, 10)} ${sample.dataHora.substring(11, 19)}`);

        const humidityChartConfig = {
            type: 'line',
            data: {
                labels: humidityLabels,
                datasets: [{
                    label: 'Umidade (%)',
                    data: humidityData,
                    backgroundColor: 'rgba(54, 162, 235, 0.5)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        };

        const temperatureData = data.map(sample => sample.temperaturaAci.toFixed(2));
        const temperatureLabels = data.map(sample => `${sample.dataHora.substring(0, 10)} ${sample.dataHora.substring(11, 19)}`);

        const temperatureChartConfig = {
            type: 'line',
            data: {
                labels: temperatureLabels,
                datasets: [{
                    label: 'Temperatura (ºC)',
                    data: temperatureData,
                    backgroundColor: 'rgba(255, 99, 132, 0.5)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: false // Você pode ajustar isto se necessário
                    }
                }
            }
        };

        var ctxPie = document.getElementById('pieChart').getContext('2d');
        new Chart(ctxPie, pieChartConfig);

        var ctxHumidity = document.getElementById('humidityChart').getContext('2d');
        new Chart(ctxHumidity, humidityChartConfig);

        var ctxTemperature = document.getElementById('temperatureChart').getContext('2d');
        new Chart(ctxTemperature, temperatureChartConfig);

        var ctxBar = document.getElementById('barChart').getContext('2d');
        new Chart(ctxBar, barChartConfig);
        // Update last temperature and humidity
        document.getElementById('temperaturaAtual').innerHTML = lastSample.temperaturaAci + "º";
        document.getElementById('umidadeAtual').innerHTML = lastSample.umidade_perc.toFixed(0) + "%";
    }
});
