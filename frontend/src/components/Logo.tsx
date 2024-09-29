interface LogoProps {
    size?: "sm" | "md" | "lg";
}

const sizeMap = {
    sm: "h-8 w-8",
    md: "h-12 w-12",
    lg: "h-16 w-16",
};

export const Logo = ({ size = "md" }: LogoProps) => {
    return (
        <a href="/" className={sizeMap[size]}>
            <img src="../assets/Logo.png" alt="Logo"></img>
        </a>
    )
}
