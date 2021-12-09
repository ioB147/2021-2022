#include <iostream>
#include <cmath>
using namespace std;
 
void derivative(int x, int y);

int main() 
{
    int x;
	int	y;
	cout << "x= "; cin >> x;
    cout << "y= "; cin >> y;
    derivative(x, y);
	return 0;
}
void derivative(int x, int y) {
	double sum;
	cout << "f(x)= "<< x << " ^ " << y << endl;
	sum = y*pow(x,y-1);
	cout << "f'(x)= " << sum;
}

