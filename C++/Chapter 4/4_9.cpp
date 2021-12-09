#include<iostream>
using namespace std;

int main() {
	
	int month, year;
	cout << "Enter a month(1-12): ";
		cin >> month;
	cout << "Enter a year: ";
	    cin >> year;
	
	switch (month) {
	case 1: cout << "31 days";
	break;
	case 2: 
	if((year % 4 == 0) || ((year % 100 !=0) && (year % 400 ==0))) {
		cout << "29 days";
	} else {
		cout << "28 days";
	}
	break;
	case 3: cout << "31 days";
	break;
	case 4: cout << "30 days";
	break;
	case 5: cout << "31 days";
	break;
	case 6: cout << "30 days";
	break;
	case 7: cout << "31 days";
	break;
	case 8: cout << "31 days";
	break;
	case 9: cout << "30 days";
	break;
	case 10: cout << "31 days";
	break;
	case 11: cout << "30 days";
	break;
	case 12: cout << "31 days";
	break;	
	}	
	return 0;
}
