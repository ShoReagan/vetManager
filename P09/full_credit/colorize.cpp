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
    std::cout << red.to_string() << std::endl;
    std::cout << red.colorize("RED") << std::endl; 
}