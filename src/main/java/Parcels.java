import java.util.ArrayList;

public class Parcels {
  private double mLength;
  private double mWidth;
  private double mHeight;
  private double mWeight;
  private int mDelivery;

  public Parcels(double length, double width, double height, double weight, int delivery){
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
    mDelivery = delivery;
  }
  public double getVolume(){
    return mLength * mWidth * mHeight;
  }
  public double getPrice(){
    double price = 0;
    price += Math.pow(mWeight * 0.5, 1.2);
    if(mDelivery == 1){
      price += 20 + (20 * mWeight/100);
    }
    else if(mDelivery == 2){
      price += 9 + (9 * mWeight/100);
    }
    else{
      price += 3 + (3 * mWeight/100);
    }
    price += Math.pow(getVolume()*.03, 0.5);
    return price;
  }
}
