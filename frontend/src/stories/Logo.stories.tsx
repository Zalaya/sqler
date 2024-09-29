import { Logo } from "../components/Logo.tsx";
import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";

type StoryProps = ComponentProps<typeof Logo>;

const meta: Meta<StoryProps> = {
    component: Logo,
};

export default meta;

type Story = StoryObj<StoryProps>;

export const Small: Story = {
    args: {
        size: "sm"
    }
};

export const Medium: Story = {
    args: {
        size: "md"
    }
};

export const Large: Story = {
    args: {
        size: "lg"
    }
};