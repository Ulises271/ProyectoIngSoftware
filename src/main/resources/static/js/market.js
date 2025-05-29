

const apiKey = '26a5cea2feeacca4ed81503a';  
const url = `https://v6.exchangerate-api.com/v6/${apiKey}/latest/USD`;

const monedas = {
    mxn: "MXN",
    eur: "EUR",
    jpy: "JPY",
    gbp: "GBP",
    chf: "CHF",
    cad: "CAD",
    cny: "CNY",
    aud: "AUD",
    brl: "BRL"
};

window.addEventListener('DOMContentLoaded', () => {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data.result === "success") {
                for (const id in monedas) {
                    const code = monedas[id];
                    const rate = data.conversion_rates[code];
                    const label = document.getElementById(id);
                    if (label) {
                        const valorAnterior = parseFloat(label.textContent);
                        const cambio = rate - valorAnterior;
                        const porcentaje = ((cambio / valorAnterior) * 100).toFixed(1);
                        const claseCambio = cambio >= 0 ? 'subida' : 'caida';
                        const signo = cambio >= 0 ? '+' : '';
                        label.innerHTML = `${rate.toFixed(2)} <span class="${claseCambio}">${signo}${porcentaje}%</span>`;
                    }
                }

                const fechaActual = new Date().toLocaleDateString('es-MX');
                const fechaLabel = document.getElementById("fecha-actualizacion");
                if (fechaLabel) {
                    fechaLabel.innerHTML = `Última actualización <br>${fechaActual}`;
                }
            } else {
                console.error("Error en los datos de la API:", data);
            }
        })
        .catch(error => {
            console.error('Error al obtener los datos:', error);
        });
});



