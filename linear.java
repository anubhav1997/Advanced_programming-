public class linear {
   
    private final double intercept, slope;
   
    public linear(Double[] a, Double[] b) {
        
        int n = a.length;

        
        double meana,meanb,standeva,standevb; 

        double suma = 0.0, sumb = 0.0, suma2 = 0.0;

        for (int i = 0; i < n; i++) {
            suma += b[i];
            suma2 += a[i]*a[i];
            sumb  += b[i];
        }

        meana=suma/n;
        meanb=sumb/n;

        
        double aabar = 0.0, bbbar = 0.0, abbar = 0.0;
       
        for (int i = 0; i < n; i++) 
        {
            aabar += (a[i] - meana) * (a[i] - meana);
            bbbar += (b[i] - meanb) * (b[i] - meanb);
            abbar += (a[i] - meana) * (b[i] - meanb);
        }

        standeva=Math.sqrt(aabar/n);
        standevb=Math.sqrt(bbbar/n);

        double corel = Correlation(a,b);
        slope  = (abbar / aabar)*corel;     
        intercept = meanb - slope * meana;

       
    } 

    public double predict(double x) {
        return slope*x + intercept;
    }

    public static double Correlation(Double[] xs, Double[] ys) 
    {
  
    double sx = 0.0;
    double sy = 0.0;
    double sxx = 0.0;
    double syy = 0.0;
    double sxy = 0.0;

    int n = xs.length;

    for(int i = 0; i < n; ++i) {
      double x = xs[i];
      double y = ys[i];

      sx += x;
      sy += y;
      sxx += x * x;
      syy += y * y;
      sxy += x * y;
    }

    double cov = sxy / n - sx * sy / n / n;

    double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
  
    double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);

    return cov / sigmax / sigmay;

  }

    public static void main(String[] args)
    {

    }

}


