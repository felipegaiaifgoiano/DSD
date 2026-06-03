Rails.application.routes.draw do

  root "produtos#index"

  post "/salvar",
       to: "produtos#salvar"

end