using System;
using System.Collections.Generic;

namespace SOLID.SRP
{
    public class Item
    {
        public string Identificador { get; set; }
        public int Cantidad { get; set; }
        public string CodigoInventario { get; set; }
        public double Precio { get; set; }
    }

    public class CarritoDeCompras
    {
        public LugarCompra LugarDeCompra { get; set; }
        public decimal MontoTotal { get; set; }
        public List<Item> Items { get; set; }
        public string CorreoElectronicoCliente { get; set; }

        public CarritoDeCompras()
        {
            Items = new List<Item>();
        }
    }

    public enum FormaDePago
    {
        TarjetaDeCredito,
        Efectivo,
        Cheque
    }

    public enum LugarCompra
    {
        EnTienda,
        OnLine,
        Telefono
    }

    public abstract class DetallesDePago
    {
        public FormaDePago FormaDePagoParaCompra { get; set; }
        public string NumeroDeTarjetaDeCredito { get; set; }
        public DateTime FechaExpiracion { get; set; }
        public string NombreTarjetaHabiente { get; set; }
    }

    public class Orden
    {
        public void Checkout(CarritoDeCompras carritoDeCompras, DetallesDePago detallesDePago, bool notificarCliente)
        {
            if (detallesDePago.FormaDePagoParaCompra == FormaDePago.TarjetaDeCredito)
            {
                // Procesar pago con tarjeta de crédito;
            }

            if (carritoDeCompras.LugarDeCompra == LugarCompra.OnLine)
            {
                // Reservar Inventario
            }

            if (notificarCliente)
            {
                NotificarCliente(carritoDeCompras);
            }
        }

        public void NotificarCliente(CarritoDeCompras carrito)
        {
            string correoElectronicoCliente = carrito.CorreoElectronicoCliente;
            if (!string.IsNullOrEmpty(correoElectronicoCliente))
            {
                // Envia mensaje
            }
        }
    }
}
