class CreateProdutos < ActiveRecord::Migration[8.0]

  def change
    create_table :produtos do |t|
      t.string :nome
	  t.references :categoria,
                   null: false,
                   foreign_key: {
                     to_table: :categorias
                   }
    end
  end
end