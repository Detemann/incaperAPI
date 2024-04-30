document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/soil')
        .then(response => response.json())
        .then(data => {
            // Configurações do gráfico de Pizza NPK
            const lastSample = data[data.length - 1];
            const pieData = [0, 0, 0];
            data.forEach(sample => {
                pieData[0] += sample.n_perc;
                pieData[1] += sample.p_perc;
                pieData[2] += sample.k_perc;
            });
            let total = 0;
            total = pieData[0] + pieData[1] + pieData[2];
            for (let i = 0; i < pieData.length; i++) {
                pieData[i] = (pieData[i] / total) * 100
                pieData[i] = pieData[i].toFixed(2);
            }
            const pieLabels = ['N%', 'P%', 'K%'];

            const pieChartConfig = {
                type: 'doughnut',
                data: {
                    labels: pieLabels,
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

            // Configurações do gráfico de Linha de Umidade
            const humidityData = data.slice(-7).map(sample => sample.umidade_perc);
            const humidityLabels = data.slice(-7).map(sample => `${sample.data} ${sample.hora}`);

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

            var ctxPie = document.getElementById('pieChart').getContext('2d');
            new Chart(ctxPie, pieChartConfig);

            var ctxHumidity = document.getElementById('humidityChart').getContext('2d');
            new Chart(ctxHumidity, humidityChartConfig);

            // Função para retornar a última umidade
            const getLastHumidity = () => {
                return lastSample.umidade_perc;
            };

            // Função para retornar a última temperatura
            const getLastTemperature = () => {
                return lastSample.temperatura;
            };

            // Exemplo de uso das funções
            const lastHumidity = getLastHumidity();
            const lastTemperature = getLastTemperature();
            console.log('Última Umidade:', lastHumidity);
            console.log('Última Temperatura:', lastTemperature);
            document.getElementById('umidadeAtual').innerHTML = getLastHumidity() + "%";
            document.getElementById('temperaturaAtual').innerHTML = getLastTemperature();
        })
        .catch(error => console.error('Erro ao buscar dados:', error));
});

document.addEventListener('DOMContentLoaded', function () {
    fetchChartData();

    function fetchChartData(days = 7) {
        fetch('http://localhost:8080/soil')
            .then(response => response.json())
            .then(data => {
                data = data.slice(-days);
                updateCharts(data);
            })
            .catch(error => console.error('Erro ao buscar dados:', error));
    }

    function updateCharts(data) {
        const npkData = data.map(sample => [sample.n_perc, sample.p_perc, sample.k_perc]);
        const npkLabels = data.map(sample => `${sample.data} ${sample.hora}`);

        const barChartNPKConfig = {
            type: 'bar',
            data: {
                labels: npkLabels,
                datasets: [
                    {
                        label: 'N%',
                        data: npkData.map(npk => npk[0]),
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1
                    },
                    {
                        label: 'P%',
                        data: npkData.map(npk => npk[1]),
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    },
                    {
                        label: 'K%',
                        data: npkData.map(npk => npk[2]),
                        backgroundColor: 'rgba(255, 206, 86, 0.2)',
                        borderColor: 'rgba(255, 206, 86, 1)',
                        borderWidth: 1
                    }
                ]
            },
            options: {
                scales: {
                    x: {
                        stacked: false
                    },
                    y: {
                        beginAtZero: true
                    }
                }
            }
        };

        const humidityData = data.map(sample => sample.umidade_perc);
        const humidityLabels = data.map(sample => `${sample.data} ${sample.hora}`);

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

        const Winddata = {
            labels: [
                'Direção'
            ],
            datasets: [{
                label: [''],
                data: [0, 0, 0, 0, 0, 15],
                backgroundColor: [
                    'rgb(135, 206, 250)'
                ]
            }]
        };

        const WindChartconfig = {
            type: 'polarArea',
            data: Winddata,
            options: {
                elements: {
                    arc: {
                        angle: 20
                    }
                }
            }
        };

        if (window.myCharts) {
            window.myCharts.forEach(chart => chart.destroy());
        }
        let ctxHumidity = document.getElementById('humidityChart').getContext('2d');
        let ctxNPK = document.getElementById('chart2').getContext('2d');
        let ctxWind = document.getElementById('chart3').getContext('2d');
        window.myCharts = [
            new Chart(ctxHumidity, humidityChartConfig),
            new Chart(ctxNPK, barChartNPKConfig),
            new Chart(ctxWind, WindChartconfig)
        ];
    }
});
