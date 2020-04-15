from django.db import models

# Create your models here.
import uuid

class Temperature(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    type = models.CharField(verbose_name='Temperatura', max_length=20)
    value = models.IntegerField(verbose_name='Grados')
    created = models.DateTimeField(auto_now_add=True)
    updated = models.DateTimeField(auto_now=True)