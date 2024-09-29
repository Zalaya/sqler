import LogoImage from "../assets/Logo.png";

type LogoProps = {
    size?: "sm" | "md" | "lg";
}

const sizeMap = {
    sm: "h-8 w-8",
    md: "h-12 w-12",
    lg: "h-16 w-16",
};

export const Logo = ({ size = "md" }: LogoProps) => {
    return (
        <a href="/">
            <img src={LogoImage} alt="Logo" className={sizeMap[size]}></img>
        </a>
    )
}
