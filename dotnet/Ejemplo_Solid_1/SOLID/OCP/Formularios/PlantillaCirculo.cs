using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing.Drawing2D;

namespace SOLID.OCP
{
    public partial class PlantillaCirculo : Form
    {
        public PlantillaCirculo()
        {
            InitializeComponent();
        }

        private void PlantillaCirculo_Load(object sender, EventArgs e)
        {
            Height = 100;
            Width = 100;
            GraphicsPath path = new GraphicsPath();
            path.AddEllipse(0, 0, 100, 100);
            Region = new Region(path);

            BackColor = CreateRandomColor();
        }

        protected Color CreateRandomColor()
        {
            Random randonGen = new Random();
            Color randomColor = Color.FromArgb(randonGen.Next(255), randonGen.Next(255), randonGen.Next(255));

            return randomColor;
        }

        private void PlantillaCirculo_Click(object sender, EventArgs e)
        {
            Close();
        }

    }
}
