using Microsoft.EntityFrameworkCore;
using App.Models;

namespace App.Data;

public class AppDbContext : DbContext
{
    public AppDbContext(
        DbContextOptions<AppDbContext> options)
        : base(options)
    {
    }

    public DbSet<Produto> Produtos => Set<Produto>();
	public DbSet<Categoria> Categorias => Set<Categoria>();
}