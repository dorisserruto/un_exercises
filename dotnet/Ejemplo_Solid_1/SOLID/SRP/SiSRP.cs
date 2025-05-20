

namespace SOLID.SRP
{
    public interface IServicioDeNotificacion
    {
        void NotificarClienteOrdenCreada(CarritoDeCompras carrito);
    }

    public interface IServicioDePago
    {
        void ProcesarTarjetaDeCredito(DetallesDePago detallesDePago, decimal cantidadDeDinero);
    }

    public abstract class Pedido
    {
        protected Pedido(CarritoDeCompras carritoDeCompras)
        {
            CarritoDeCompras = carritoDeCompras;
        }

        protected CarritoDeCompras CarritoDeCompras { get; set; }

        protected virtual void Checkout()
        {
            // Acciones o funcionalidad comun a todas las operaciones de checkout
        }
    }

    public class PedidoEnEfectivo : Pedido
    {
        public PedidoEnEfectivo(CarritoDeCompras carritoDeCompras)
            : base(carritoDeCompras)
        { }
    }

    public class PedidoConTarjetaDeCredito : Pedido
    {
        private readonly DetallesDePago _detallesDePago;
        private readonly IServicioDePago _servicioDePago;

        public PedidoConTarjetaDeCredito(CarritoDeCompras carritoDeCompras, 
                                         DetallesDePago paymentDetails, 
                                         IServicioDePago paymentService)
            : base(carritoDeCompras)
        {
            _detallesDePago = paymentDetails;
            _servicioDePago = paymentService;
        }

        protected override void Checkout()
        {
            _servicioDePago.ProcesarTarjetaDeCredito(_detallesDePago, CarritoDeCompras.MontoTotal);
            base.Checkout();
        }
    }

    public class PedidoEnLinea : Pedido
    {
        private readonly IServicioDeNotificacion _servicioDeNotificacion;
        private readonly DetallesDePago _detallesDePago;
        private readonly IServicioDePago _servicioDePago;

        public PedidoEnLinea(CarritoDeCompras carritoDeCompras,
                             DetallesDePago detallesDePago, 
                             IServicioDeNotificacion servicioDeNotificacion, 
                             IServicioDePago servicioDePago)
            : base(carritoDeCompras)
        {
            _detallesDePago = detallesDePago;
            _servicioDePago = servicioDePago;
            _servicioDeNotificacion = servicioDeNotificacion;
        }

        protected override void Checkout()
        {
            _servicioDePago.ProcesarTarjetaDeCredito(_detallesDePago, CarritoDeCompras.MontoTotal);
            _servicioDeNotificacion.NotificarClienteOrdenCreada(CarritoDeCompras);
            base.Checkout();
        }
    }
}
