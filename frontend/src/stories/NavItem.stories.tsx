import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";
import { NavItem } from "../components/ui/NavItem.tsx";
import { FaHome } from "react-icons/fa";

type StoryProps = ComponentProps<typeof NavItem>;

const meta: Meta<StoryProps> = {
    title: "UI/NavItem",
    component: NavItem
};

export default meta;

type Story = StoryObj<StoryProps>;

export const Default: Story = {
    args: {
        icon: <FaHome />,
        children: "Home"
    }
};