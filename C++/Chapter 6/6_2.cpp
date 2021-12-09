#include <iostream>
using namespace std;
 
double getLength();
double getWidth();
double getArea(double&, double&);
void displayData(double&, double&, double&);

int main() 
{
    double length, width, area;
    length = getLength();

    width = getWidth();

    area = getArea(length, width);

    displayData(length, width, area);

    return 0;
}

double getLength()
{
    double length;
    cout << "Enter the rectangle's length: ";
    cin >> length;
    return length;
}

double getWidth()
{
    double width;
    cout << "Enter the rectangle's width: ";
    cin >> width;
    return width;
}

double getArea(double& l, double& w)
{
    return l*w;
}

void displayData(double& l, double& w, double& a)
{
    cout << "Length: " << l << " | Width: " << w << " | Area: " << a <<endl;
}