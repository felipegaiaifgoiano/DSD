using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

using App.Data;
using App.Models;

namespace App.Controllers;

public class ProdutoController : Controller
{
    private readonly AppDbContext _db;

    public ProdutoController(AppDbContext db)
    {
        _db = db;
    }

    public IActionResult Index()
    {
        ViewBag.Categorias =
            _db.Categorias.ToList();

        var produtos = _db.Produtos
            .Include(p => p.Categoria)
            .ToList();

        return View(produtos);
    }

    [HttpPost]
    public IActionResult Salvar(
        string nome,
        int categoriaId)
    {
    	var produto = new Produto
        {
            Nome = nome,
            CategoriaId = categoriaId
        };

        _db.Produtos.Add(produto);
        _db.SaveChanges();

        return RedirectToAction("Index");
    }
}