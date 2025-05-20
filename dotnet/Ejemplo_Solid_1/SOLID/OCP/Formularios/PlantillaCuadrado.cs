using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace SOLID.OCP
{
    public partial class PlantillaCuadrado : Form
    {
        public PlantillaCuadrado()
        {
            InitializeComponent();
        }

        private void PlantillaCuadrado_Load(object sender, EventArgs e)
        {
            BackColor = CreateRandomColor();
        }

        protected Color CreateRandomColor()
        {
            Random randonGen = new Random();
            Color randomColor = Color.FromArgb(randonGen.Next(255), randonGen.Next(255), randonGen.Next(255));

            return randomColor;
        }

        private void PlantillaCuadrado_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
