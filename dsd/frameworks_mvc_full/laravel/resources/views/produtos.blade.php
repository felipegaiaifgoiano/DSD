<h1>Produtos</h1>

<form action="/salvar"
      method="post">

    @csrf

    <input
        name="nome"
        placeholder="Nome">

    <select name="categoria_id">

        @foreach ($categorias as $c)
            <option value="{{ $c->id }}">
                {{ $c->nome }}
            </option>
        @endforeach

    </select>

    <button type="submit">
        Salvar
    </button>

</form>

<hr>

<h2>Produtos cadastrados</h2>

<ul>

@foreach ($produtos as $p)
    <li>
        {{ $p->nome }}
        -
        {{ $p->categoria->nome }}
    </li>
@endforeach

</ul>