from django.shortcuts import render

# Create your views here.
from rest_framework import viewsets
from .models import Temperature
from .serializers import TemperatureSerializer

class TemperatureViewSet(viewsets.ModelViewSet):
    queryset = Temperature.objects.all().order_by('-created')
    serializer_class = TemperatureSerializer
