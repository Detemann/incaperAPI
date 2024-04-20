document.addEventListener('DOMContentLoaded', function () {
    fillTable1(); // Preenche a tabela 1
    fillTable2(); // Preenche a tabela 2
  });
  
  function fillTable1() {
    const months = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho'];
    const temperatures = [20, 21, 23, 25, 27, 28];
  
    const table = document.getElementById('table1').getElementsByTagName('tbody')[0];
  
    for (let i = 0; i < months.length; i++) {
      const row = table.insertRow();
      const cell1 = row.insertCell(0);
      const cell2 = row.insertCell(1);
  
      cell1.textContent = months[i];
      cell2.textContent = temperatures[i] + ' °C';
    }
  }
  
  function fillTable2() {
    const weatherTypes = ['Chuva', 'Sol', 'Nublado', 'Chuva Forte', 'Neve', 'Vento'];
    const occurrences = [5, 20, 10, 3, 0, 7];
  
    const table = document.getElementById('table2').getElementsByTagName('tbody')[0];
  
    for (let i = 0; i < weatherTypes.length; i++) {
      const row = table.insertRow();
      const cell1 = row.insertCell(0);
      const cell2 = row.insertCell(1);
  
      cell1.textContent = weatherTypes[i];
      cell2.textContent = occurrences[i] + ' dias';
    }
  }
