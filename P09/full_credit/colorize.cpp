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
            return "(" + _red + "," + _green + "," + _blue + ")" + std::endl;
        }
        std::string colorize(std::string text) {
            return "\033[38;2;" + _red + ";" + _green + ";" + _blue + "m"
              + text             
              + "\033[0m"              
              + std::endl;
        }
}

int main() {
    Color red(255, 0, 0);
    std::cout << red.colorize("RED") << std::endl; 
}