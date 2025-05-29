const img_principal = document.getElementById("img-principal");
const p=document.getElementById("p_principal");
const estilo="3px solid white";
const bs_all = {
    ini:document.getElementById("bs_inicio"),
    serv:document.getElementById("bs_servicios"),
    cont:document.getElementById("bs_contacto"),
}
const secc={
    ini:document.getElementById("s2"),
    serv:document.getElementById("s3"),
    cont:document.getElementById("s4"),
}
const imgs={
    ini:"recursos/graficapapel.jpg",
    serv:"recursos/servicios_img.jpg",
    cont:"recursos/call.jpg",
}
const parr={
    ini:"En BANCORA, ponemos a tu alcance las mejores herramientas financieras y tecnológicas para ayudarte a interpretar el mercado, tomar decisiones inteligentes y construir un futuro sólido.",
    serv:"En BANCORA, nuestros servicios están diseñados para adaptarse a tu vida: desde soluciones digitales ágiles hasta atención personalizada, te acompañamos en cada paso para que tu experiencia financiera sea segura, sencilla y eficiente.",
    cont:"¿Tienes dudas o necesitas ayuda? En BANCORA estamos aquí para escucharte.",
}
const inicializar=()=>{
    for(let llave in bs_all){//Eliminia selecciones
        bs_all[llave].style.borderBottom="none";
        secc[llave].style.display="none"
    }
    bs_all["ini"].style.borderBottom=estilo;
    secc["ini"].style.display="block";
}
const cambio=(ventana)=>{
    for(let llave in bs_all){//Eliminia selecciones
        bs_all[llave].style.borderBottom="none";
        secc[llave].style.display="none"
    }
    
    if(ventana=="inicio"){
        bs_all["ini"].style.borderBottom=estilo;
        secc["ini"].style.display="block";
        img_principal.src=imgs["ini"];
        p.innerText=parr["ini"];
    }else if(ventana=="servicios"){
        bs_all["serv"].style.borderBottom=estilo;
        secc["serv"].style.display="block";
        img_principal.src=imgs["serv"];
        p.innerText=parr["serv"];
    }else if(ventana=="contacto"){
        bs_all["cont"].style.borderBottom=estilo;
        secc["cont"].style.display="block";
        img_principal.src=imgs["cont"];
        p.innerText=parr["cont"];
    }
}



inicializar();