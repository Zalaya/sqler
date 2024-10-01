import { Logo } from "../components/ui/Logo.tsx";
import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";
import { fn } from "@storybook/test";

type StoryProps = ComponentProps<typeof Logo>;

const meta: Meta<StoryProps> = {
    title: "Logo",
    component: Logo,
    args: {
        hasColor: true,
        onClick: fn()
    }
};

export default meta;

type Story = StoryObj<StoryProps>;

export const Small: Story = {
    args: {
        size: "sm",
        hasColor: true
    }
};

export const Medium: Story = {
    args: {
        size: "md",
        hasColor: true
    }
};

export const Large: Story = {
    args: {
        size: "lg",
        hasColor: true
    }
};
