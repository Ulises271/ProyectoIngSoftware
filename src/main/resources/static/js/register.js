document.addEventListener("DOMContentLoaded", () => {
    const button = document.getElementById("button");

    button.addEventListener("click", async (e) => {
        e.preventDefault();

        const data = {
            nombre: document.getElementById("nombre").value,
            apellidos: document.getElementById("apellidos").value,
            direccion: "direccion default",
            telefono: "0000000000",
            email: document.getElementById("email").value,
            usuario: document.getElementById("usuario").value,
            contrasena: document.getElementById("contrasena").value,
            fechaNacimiento: document.getElementById("fechaNacimiento").value
        };

        console.log("📅 Fecha enviada:", data.fechaNacimiento);

        try {
            const response = await fetch("http://localhost:8080/api/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                alert("Registro exitoso");
                window.location.href = "login.html";
            } else {
                const error = await response.text();
                alert("Error en el registro: " + error);
            }
        } catch (err) {
            alert("Error de red: " + err);
        }
    });
});
