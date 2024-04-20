document.addEventListener('DOMContentLoaded', function () {
    // Dados fictícios relacionados ao clima para os gráficos
    const data1 = {
      labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho'],
      datasets: [{
        label: 'Temperatura Média (°C)',
        data: [20, 21, 23, 25, 27, 28],
        backgroundColor: 'rgba(255, 99, 132, 0.5)',
        borderColor: 'rgba(255, 99, 132, 1)',
        borderWidth: 1
      }]
    };
  
    const data2 = {
      labels: ['Chuva', 'Sol', 'Nublado', 'Chuva Forte', 'Neve', 'Vento'],
      datasets: [{
        label: 'Ocorrência (dias)',
        data: [5, 20, 10, 3, 0, 7],
        backgroundColor: [
          'rgba(255, 99, 132, 0.5)',
          'rgba(54, 162, 235, 0.5)',
          'rgba(255, 206, 86, 0.5)',
          'rgba(75, 192, 192, 0.5)',
          'rgba(153, 102, 255, 0.5)',
          'rgba(255, 159, 64, 0.5)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 2
      }]
    };
  
    // Configuração dos gráficos
    const config1 = {
      type: 'line',
      data: data1,
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    };
  
    const config2 = {
      type: 'bar',
      data: data2,
      options: {
        plugins: {
          legend: {
            position: 'top',
          },
        },
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    };
  
    // Renderização dos gráficos
    var ctx1 = document.getElementById('chart1').getContext('2d');
    var myChart1 = new Chart(ctx1, config1);
  
    var ctx2 = document.getElementById('chart2').getContext('2d');
    var myChart2 = new Chart(ctx2, config2);
  });
  