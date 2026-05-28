using App.Data;
using App.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<AppDbContext>(
    options =>
        options.UseSqlite(
            "Data Source=app.db"));

var app = builder.Build();

app.UseStaticFiles();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Produto}/{action=Index}/{id?}");

using (var scope = app.Services.CreateScope())
{
    var db = scope.ServiceProvider
        .GetRequiredService<AppDbContext>();

    db.Database.EnsureCreated();

    if (!db.Categorias.Any())
    {
        db.Categorias.AddRange(

            new Categoria {
                Nome = "Informática"
            },

            new Categoria {
                Nome = "Escritório"
            },

            new Categoria {
                Nome = "Games"
            }

        );

        db.SaveChanges();
    }
}

app.Run();