#include <iostream>

using namespace std;

int main() {

    char ch;

    cout << "Enter a character : ";
    cin >> ch;

    if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

        cout << "A";

    } else if(ch >= '0' && ch <= '9') {

        cout << "D";

    } else {

        cout << "S";

    }

    return 0;
}