const serverPath = "http://localhost"; //http://168.138.248.181

document.addEventListener("DOMContentLoaded", function () {
  // Seu código JavaScript aqui
  fetchDataForSoil();
  fetchDataForAtmosphere();
  fetchDataForEvapotranspiration();
});

document.querySelectorAll(".dropdown-toggle").forEach((item) => {
  item.addEventListener("click", (event) => {
    if (event.target.classList.contains("dropdown-toggle")) {
      event.target.classList.toggle("toggle-change");
    } else if (
      event.target.parentElement.classList.contains("dropdown-toggle")
    ) {
      event.target.parentElement.classList.toggle("toggle-change");
    }
  });
});

// Método para buscar dados da API
function fetchDataForSoil() {
  fetch(serverPath + ":8080/soil")
    .then((response) => response.json())
    .then((data) => {
      const tableBody = document.getElementById("terra").childNodes[1];
      //tableBody.innerHTML = '';
      data.forEach((item) => {
        const row = document.createElement("tr");
        row.innerHTML = `
              <td>${item.umidade_perc.toFixed(2)}%</td>
              <td>${item.n_perc.toFixed(2)}</td>
              <td>${item.p_perc.toFixed(2)}</td>
              <td>${item.k_perc.toFixed(2)}</td>
              <td>${item.dataHora.substring(0, 10)}</td>
            `;
        tableBody.appendChild(row);
      });
    })
    .catch((error) => console.error("Erro ao buscar dados:", error));
}

function fetchDataForAtmosphere() {
  fetch(serverPath + ":8080/atmosphere")
    .then((response) => response.json())
    .then((data) => {
      const tableBody = document.getElementById("atmosphere").childNodes[1];
      //tableBody.innerHTML = '';
      data.forEach((item) => {
        const row = document.createElement("tr");
        row.innerHTML = `
              <td>${
                item.temperature ? item.temperature.toFixed(0) : "-"
              } °C</td>
              <td>${item.humidity ? item.humidity.toFixed(2) : "-"}%</td>
              <td>${
                item.pluviometer ? item.pluviometer.toFixed(0) : "-"
              } mm</td>
            `;
        tableBody.appendChild(row);
      });
    })
    .catch((error) => console.error("Erro ao buscar dados:", error));
}

function fetchDataForEvapotranspiration() {
  fetch(serverPath + ":8080/samples/eto")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      const tableBody = document.getElementById("evapotranspiracao");
      console.log(tableBody);
      tableBody.innerHTML = (typeof data == "number" ? data.toFixed(3) : "-") + " mm";
    })
    .catch((error) => console.error("Erro ao buscar dados:", error));
}
