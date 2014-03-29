package harryPotterMod.tombenpotter.harrypottermod.client.codechicken.lib.alg;

public class MathHelper
{
  public static final double phi = 1.618034D;
  
  public static float approachLinear(float a, float b, float max)
  {
    return b - a < max ? b : a > b ? a - max : a - b < max ? b : a + max;
  }
  
  public static double approachLinear(double a, double b, double max)
  {
    return b - a < max ? b : a > b ? a - max : a - b < max ? b : a + max;
  }
  
  public static float interpolate(float a, float b, float d)
  {
    return a + (b - a) * d;
  }
  
  public static double interpolate(double a, double b, double d)
  {
    return a + (b - a) * d;
  }
  
  public static double approachExp(double a, double b, double ratio)
  {
    return a + (b - a) * ratio;
  }
  
  public static double approachExp(double a, double b, double ratio, double cap)
  {
    double d = (b - a) * ratio;
    if (Math.abs(d) > cap) {
      d = Math.signum(d) * cap;
    }
    return a + d;
  }
  
  public static double retreatExp(double a, double b, double c, double ratio, double kick)
  {
    double d = (Math.abs(c - a) + kick) * ratio;
    if (d > Math.abs(b - a)) {
      return b;
    }
    return a + Math.signum(b - a) * d;
  }
  
  public static double clip(double value, double min, double max)
  {
    if (value > max) {
      value = max;
    }
    if (value < min) {
      value = min;
    }
    return value;
  }
  
  public static boolean between(double a, double x, double b)
  {
    return (a <= x) && (x <= b);
  }
  
  public static int approachExpI(int a, int b, double ratio)
  {
    int r = (int)Math.round(approachExp(a, b, ratio));
    return r == a ? b : r;
  }
  
  public static int retreatExpI(int a, int b, int c, double ratio, int kick)
  {
    int r = (int)Math.round(retreatExp(a, b, c, ratio, kick));
    return r == a ? b : r;
  }
}
