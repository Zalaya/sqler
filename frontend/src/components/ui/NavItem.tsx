import { ReactNode } from "react";

type NavItemProps = {
    children: ReactNode;
    href?: string;
    icon?: ReactNode;
}

export const NavItem = ({ children, href = "#", icon }: NavItemProps) => {
    return (
        <a href={ href } className={ `px-4 py-2 font-semibold inline-flex items-center text-white bg-slate-800 hover:bg-white hover:text-slate-800 space-x-2 rounded-md transition-colors duration-200 shadow-md` }>
            { icon && <span>{ icon }</span> } <span>{ children }</span>
        </a>
    )
}