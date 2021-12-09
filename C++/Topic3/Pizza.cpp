#include <iostream>
#include <math.h>
#include <string.h>
#include <cmath>
#include <string>
#include <iomanip>

#define PI 3.14

using namespace std;

int main() {
    int d;
    cout << "Enter your desired pizza diameters here: ";
    cin >> d;
    int n = ceil((float)(pow((float)d/2,2)*PI)/14.125);
    cout << "Your pizza will have " << n << " slices. \n";
    int s = n/2;
    if (n % 2 == 1) s++;
    if (n == 1) s = 0;
    cout << "The number of cutting will be " << s << "."; 
}