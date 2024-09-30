import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";
import { NavBar } from "../components/NavBar.tsx";

type StoryProps = ComponentProps<typeof NavBar>;

const meta: Meta<StoryProps> = {
    title: "NavBar",
    component: NavBar,
    args: {
        opacity: 100,
        minOpacity: 50
    }
};

export default meta;

type Story = StoryObj<StoryProps>;

export const WithLogo: Story = {
    args: {
        hasLogo: true
    }
};

export const WithoutLogo: Story = {
    args: {
        hasLogo: false
    }
};
