#include <iostream>
using namespace std;

int main () {
    int num;

    cout <<"Enter a number within the range of 1 through 10, \n";
    cout <<"and I will display the Roman numeral version of that number. \n";
    cin >> num;
    if (num < 1 || num > 10) {
        cout <<"Error!";
    }
    else
    cout <<"The Roman numberal version of ";
    switch (num)
    {
    case 1:cout << num <<" is I. \n"; break;
    case 2:cout << num <<" is II. \n"; break;
    case 3:cout << num <<" is III. \n"; break;
    case 4:cout << num <<" is IV. \n"; break;
    case 5:cout << num <<" is V. \n"; break;
    case 6:cout << num <<" is VI. \n"; break;
    case 7:cout << num <<" is VII. \n"; break;
    case 8:cout << num <<" is VIII. \n"; break;
    case 9:cout << num <<" is IX. \n"; break;
    case 10:cout << num <<" is X. \n"; break;
    }
    return 0;
}