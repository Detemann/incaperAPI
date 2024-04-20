document.addEventListener('DOMContentLoaded', function () {
  fetch('http://uclincaper.servehttp.com:8080/soil')
    .then(response => response.json())
    .then(data => {
      // Configurações do gráfico de Pizza NPK
      const lastSample = data[data.length - 1];
      const pieData = [lastSample.n_perc, lastSample.p_perc, lastSample.k_perc];
      const pieLabels = ['N%', 'P%', 'K%'];

      const pieChartConfig = {
        type: 'pie',
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
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
});
document.addEventListener('DOMContentLoaded', function () {
  const dayFilter = document.getElementById('dayFilter');
  fetchChartData();

  dayFilter.addEventListener('change', function() {
    fetchChartData(this.value);
  });

  function fetchChartData(days = 7) {
    fetch('http://uclincaper.servehttp.com:8080/soil')
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

    if (window.myCharts) {
      window.myCharts.forEach(chart => chart.destroy());
    }
    var ctxHumidity = document.getElementById('humidityChart').getContext('2d');
    var ctxNPK = document.getElementById('chart2').getContext('2d');
    window.myCharts = [
      new Chart(ctxHumidity, humidityChartConfig),
      new Chart(ctxNPK, barChartNPKConfig)
    ];
  }
});
