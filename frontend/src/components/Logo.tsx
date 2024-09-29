import LogoColor from "../assets/LogoColor.png";
import LogoNoColor from "../assets/LogoNoColor.png";

type LogoProps = {
    size?: "xs"| "sm" | "md" | "lg" | "xl" | "2xl" | "3xl";
    color?: boolean;
}

const sizeMap = {
    "xs": "h-6 w-6",
    "sm": "h-8 w-8",
    "md": "h-12 w-12",
    "lg": "h-16 w-16",
    "xl": "h-20 w-20",
    "2xl": "h-24 w-24",
    "3xl": "h-32 w-32",
};

export const Logo = ({ size, color }: LogoProps) => {
    return (
        <img
            src={ color ? LogoColor : LogoNoColor }
            alt="Logo"
            className={ sizeMap[size] }
        />
    )
}
