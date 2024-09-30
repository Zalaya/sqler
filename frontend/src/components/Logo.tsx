import LogoColored from "../assets/loco-colored.png";
import LogoMonochrome from "../assets/logo-monochrome.png";

type LogoProps = {
    size?: "xs"| "sm" | "md" | "lg" | "xl" | "2xl" | "3xl";
    hasColor?: boolean;
    onClick?: () => void;
}

const sizeMap: Record<NonNullable<LogoProps["size"]>, string> = {
    "xs": "h-6 w-6",
    "sm": "h-8 w-8",
    "md": "h-12 w-12",
    "lg": "h-16 w-16",
    "xl": "h-20 w-20",
    "2xl": "h-24 w-24",
    "3xl": "h-32 w-32",
};

export const Logo = ({ size = "md", hasColor = true, onClick }: LogoProps) => {
    return (
        <img
            src = { hasColor ? LogoColored : LogoMonochrome }
            alt = "Logo"
            className = { sizeMap[size] }
            onClick = { onClick }
        />
    )
}
