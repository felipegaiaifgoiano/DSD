from django.shortcuts import (
    render,
    redirect
)

from .models import (
    Produto,
    Categoria
)


def index(request):

    if not Categoria.objects.exists():

        Categoria.objects.create(nome='Informática')
        Categoria.objects.create(nome='Games')
        Categoria.objects.create(nome='Escritório')

    if request.method == 'POST':

        nome = request.POST.get('nome')
        categoria_id = request.POST.get('categoria_id')

        Produto.objects.create(
            nome=nome,
            categoria_id=categoria_id
        )

        return redirect('/')

    produtos = Produto.objects.select_related('categoria')
    categorias = Categoria.objects.all()

    return render(
        request,
        'index.html',
        {
            'produtos': produtos,
            'categorias': categorias
        }
    )