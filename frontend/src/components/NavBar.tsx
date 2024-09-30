import { Logo } from "./Logo.tsx";

type NavBarProps = {
    hasLogo?: boolean;
    opacity?: 0 | 25 | 50 | 75 | 100;
}

export const NavBar = ({ hasLogo = true, opacity = 100 }: NavBarProps) => {
    return (
        <nav className={`w-full h-20 bg-slate-800 flex items-center px-2 opacity-${opacity}`}>
            { hasLogo && <Logo size="lg" hasColor={false} /> }
        </nav>
    )
}