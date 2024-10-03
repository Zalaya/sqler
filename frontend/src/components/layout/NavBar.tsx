import { NavItem } from "../ui/NavItem.tsx";
import { FaGithub, FaHome } from "react-icons/fa";
import { SiConvertio } from "react-icons/si";

export const NavBar = () => {
    return (
        <nav className={ `max-w-full h-20 bg-slate-700 relative flex items-center justify-center gap-x-4 mx-4` }>
            <NavItem icon={<FaHome/>} children="Home" />
            <NavItem icon={<SiConvertio/>} children="Converter" />
            <NavItem icon={<FaGithub/>} children="GitHub" />
        </nav>
    );
};