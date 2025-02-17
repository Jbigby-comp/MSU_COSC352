#include <iostream>
#include <string>

using namespace std;

int main() {
    string name;
    int times;

    cout << "hello, world. what's your name? ";
    cin >> name;
    cout << "enter number";
    cin >> times;

    for (int i = 0; i < times; ++i) {
        cout << "Hello," << name << endl; 
    }

    return 0;
}