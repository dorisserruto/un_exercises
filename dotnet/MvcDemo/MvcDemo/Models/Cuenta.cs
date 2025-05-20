using System.Data.Entity;

namespace MvcDemo.Models
{
    public class Cuenta
    {
        public int IdCuenta { get; set; }
        public string Nombre { get; set; }
        public string Tipo { get; set; }
        public string Cliente { get; set; }
        public decimal Saldo { get; set; }
    }

    public class BancoDbContext : DbContext
    {
        public DbSet<Cuenta> Movies { get; set; }
    }
}