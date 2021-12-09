#include <iostream>

using namespace std;

int main() {

    int i;

    cout <<"The ASCII codes and their equivalent characters from 48 to 127" <<endl;
    for (i=48; i<=127; i++) {
        cout <<i <<" = " <<char(i) <<endl;
    }
    return 0;
}