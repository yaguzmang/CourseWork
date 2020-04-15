from django.shortcuts import render, HttpResponse
import requests
# Create your views here.
def temperatures(request):
    # Verifica si hay un parámetro value en la petición GET
    if 'value' in request.GET:
        value = request.GET['value']
        # Verifica si el value no esta vacio
        if value:
            # Crea el json para realizar la petición POST al Web Service
            args = {'type': 'Centigrados', 'value': value}
            response = requests.post('http://127.0.0.1:8000/temperatures/', args)
            # Convierte la respuesta en JSON
            temperatures_json = response.json()

    # Realiza una petición GET al Web Services
    response = requests.get('http://127.0.0.1:8000/temperatures/')
    # Convierte la respuesta en JSON
    temperatures = response.json()
    # Rederiza la respuesta en el template temperatures
    return render(request, "temperatures/temperatures.html", {'temperatures': temperatures})