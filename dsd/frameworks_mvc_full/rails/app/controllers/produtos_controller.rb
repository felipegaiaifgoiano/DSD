class ProdutosController < ActionController::Base

  def index

    @produtos =
      Produto.includes(
        :categoria
      ).all

    @categorias =
      Categoria.all

  end

  def salvar

    Produto.create(
      nome: params[:nome],
      categoria_id:
        params[:categoria_id]
    )

    redirect_to "/"

  end

end