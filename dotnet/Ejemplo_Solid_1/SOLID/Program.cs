using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace SOLID
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            
            // SRP
            Application.Run(new DemoSRP());
            // OCP
            // Application.Run(new DibujarFormas());

        }
    }
}
