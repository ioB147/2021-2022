#include <iostream>
#include <cmath>
using namespace std;

int add(int x, int y)
{
  int sum;

  sum = x + y;

  return sum;
}

float add(float x, float y)
{
  float sum;

  sum = x + y;

  return sum;
}

double add(double x, double y)
{
  double sum;

  sum = x + y;

  return sum;
}

int main()
{
    int x,y;
    cout <<"Int x,y= "; cin >>x >>y;
    float a,b;
    cout <<"Float a,b= "; cin >>a >>b;
    double m,n;
    cout <<"Double m,n= "; cin >>m >>n;
    cout <<"\nSum int: " <<add(x,y);
    cout <<"\nSum float: " <<add(a,b);
    cout <<"\nSum double: " <<add(m,n);
}
