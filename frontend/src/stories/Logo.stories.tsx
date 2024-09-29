import { Logo } from "../components/Logo.tsx";
import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";
import { fn } from "@storybook/test";

type StoryProps = ComponentProps<typeof Logo>;

const meta: Meta<StoryProps> = {
    component: Logo,
    args: {
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
