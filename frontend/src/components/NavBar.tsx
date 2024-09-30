import { Logo } from "./Logo.tsx";

export const NavBar = () => {
    return (
        <nav className="w-full h-20 bg-slate-800 flex items-center px-2">
            <Logo size="lg" hasColor={true} />
        </nav>
    )
}