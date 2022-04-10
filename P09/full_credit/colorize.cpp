#include <iostream>
#include <string>

class Color {
    private: 
        int _red;
        int _green;
        int _blue;

    public:
        Color(int red, int green, int blue) {
            _red = red;
            _green = green;
            _blue = blue;
        }
        std::string to_string() {
            std::string result = "(" + std::to_string(_red) + "," + std::to_string(_green) + "," + std::to_string(_blue) + ")";
            return result;
        }
        std::string colorize(std::string text) {
            std::string colorized = "\033[38;2;" + std::to_string(_red) + ";" + std::to_string(_green) + ";" + std::to_string(_blue) + "m" + text + "\033[0m";
            return colorized;
        }
};

int main() {
    Color red(255, 0, 0);
    Color green(0, 255, 0);
    Color blue(0, 0 , 255);
    int r;
    int g;
    int b;

    std::cout << red.colorize("RED") << " " <<  green.colorize("GREEN") << " " <<  blue.colorize("BLUE") << std::endl;
    std::cout << "\n" << "Enter red, green, and blue ints: ";
    std::cin >> r >> g >> b;
    Color selected(r, g, b);
    std::cout << selected.colorize(selected.to_string()) << std::endl;
}