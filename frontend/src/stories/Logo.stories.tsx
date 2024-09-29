import { Logo } from "../components/Logo.tsx";
import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";

type StoryProps = ComponentProps<typeof Logo>;

const meta: Meta<StoryProps> = {
    component: Logo
};

export default meta;

type Story = StoryObj<StoryProps>;

export const Small: Story = {
    args: {
        size: "sm",
        color: true
    }
};

export const Medium: Story = {
    args: {
        size: "md",
        color: true
    }
};

export const Large: Story = {
    args: {
        size: "lg",
        color: true
    }
};
